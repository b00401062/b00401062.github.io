#!/usr/bin/env bash

export PATH=~/Library/Conda/bin/:$PATH
export OSCCMPATH=~/Documents/Projects/osccm
export DATASETS=~/Downloads/Researches/OSCCM/Datasets

source activate qiime

## Importing

qiime tools import \
    --type "SampleData[SequencesWithQuality]" \
    --input-path $Datasets/metadata/manifest-hmp.csv \
    --input-format SingleEndFastqManifestPhred33 \
    --output-path $DATASETS/tools-import/demux-hmp.qza

## Denoising

qiime dada2 denoise-single \
    --i-demultiplexed-seqs $DATASETS/tools-import/demux-hmp.qza \
    --p-trunc-len 0 \
    --p-trunc-q 20 \
    --p-n-threads 0 \
    --o-table $DATASETS/dada2-denoise-paired/table-hmp.qza \
    --o-representative-sequences $DATASETS/dada2-denoise-paired/rep-seqs-hmp.qza \
    --o-denoising-stats $DATASETS/dada2-denoise-paired/denoising-stats-hmp.qza

qiime feature-table merge \
    --i-tables $DATASETS/dada2-denoise-paired/table.qza \
    --i-tables $DATASETS/dada2-denoise-paired/table-hmp.qza \
    --o-merged-table $DATASETS/feature-table-merge/table-hmp.qza

## Phylogeny

qiime phylogeny align-to-tree-mafft-fasttree \
    --i-sequences $DATASETS/dada2-denoise-paired/rep-seqs-hmp.qza \
    --o-alignment $DATASETS/phylogeny-align-to-tree-mafft-fasttree/aligned-rep-seqs-hmp.qza \
    --o-masked-alignment $DATASETS/phylogeny-align-to-tree-mafft-fasttree/masked-aligned-rep-seqs-hmp.qza \
    --o-tree $DATASETS/phylogeny-align-to-tree-mafft-fasttree/unrooted-tree-hmp.qza \
    --o-rooted-tree $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree-hmp.qza

## Classifier

qiime feature-classifier extract-reads \
    --i-sequences $DATASETS/tools-import/otus.qza \
    --p-f-primer AGAGTTTGATCATGGCTCAG \
    --p-r-primer ATTACCGCGGCTGCTGGC \
    --o-reads $DATASETS/feature-classifier-extract-reads/ref-seqs-hmp.qza

qiime feature-classifier fit-classifier-naive-bayes \
    --i-reference-reads $DATASETS/feature-classifier-extract-reads/ref-seqs-hmp.qza \
    --i-reference-taxonomy $DATASETS/tools-import/ref-taxonomy.qza \
    --o-classifier $DATASETS/feature-classifier-fit-classifier-naive-bayes/classifier-hmp.qza

## Taxonomy

qiime feature-classifier classify-sklearn \
    --i-classifier $DATASETS/feature-classifier-fit-classifier-naive-bayes/classifier-hmp.qza \
    --i-reads $DATASETS/dada2-denoise-paired/rep-seqs-hmp.qza \
    --o-classification $DATASETS/feature-classifier-classify-sklearn/taxonomy-hmp.qza

qiime feature-table merge-taxa \
    --i-data $DATASETS/feature-classifier-classify-sklearn/taxonomy.qza \
    --i-data $DATASETS/feature-classifier-classify-sklearn/taxonomy-hmp.qza \
    --o-merged-data $DATASETS/feature-table-merge-taxa/taxonomy-hmp.qza

qiime taxa barplot \
    --i-table $DATASETS/feature-table-merge/table-hmp.qza \
    --i-taxonomy $DATASETS/feature-table-merge-taxa/taxonomy-hmp.qza \
    --m-metadata-file $DATASETS/metadata/metadata-hmp.tsv \
    --o-visualization $DATASETS/visualization/taxa-barplot-hmp.qzv

## ANCOM

for l in {1..7}
do
    qiime taxa collapse \
        --i-table $DATASETS/feature-table-merge/table-hmp.qza \
        --i-taxonomy $DATASETS/feature-table-merge-taxa/taxonomy-hmp.qza \
        --p-level $l \
        --o-collapsed-table $DATASETS/taxa-collapse/table-l$l-hmp.qza

    qiime composition add-pseudocount \
        --i-table $DATASETS/taxa-collapse/table-l$l-hmp.qza \
        --o-composition-table $DATASETS/composition-add-pseudocount/comp-table-l$l-hmp.qza

    qiime composition ancom \
        --i-table $DATASETS/composition-add-pseudocount/comp-table-l$l-hmp.qza \
        --m-metadata-file $DATASETS/metadata/metadata-hmp.tsv \
        --m-metadata-column Tissue \
        --o-visualization $DATASETS/visualization/composition-ancom/composition-ancom-l$l-hmp.qzv
done

source deactivate

unset OSCCMPATH
unset DATASETS
