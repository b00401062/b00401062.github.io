#!/usr/bin/env bash

qiime tools import \
    --type "FeatureData[Sequence]" \
    --input-path $DATASETS/fasta/otus.fasta \
    --output-path $DATASETS/tools-import/otus.qza

qiime tools import \
    --type "FeatureData[Taxonomy]" \
    --input-format HeaderlessTSVTaxonomyFormat \
    --input-path $DATASETS/metadata/ref-taxonomy.tsv \
    --output-path $DATASETS/tools-import/ref-taxonomy.qza

qiime feature-classifier extract-reads \
    --i-sequences $DATASETS/tools-import/otus.qza \
    --p-f-primer CCTACGGGNGGCWGCAG \
    --p-r-primer GACTACHVGGGTATCTAATCC \
    --o-reads $DATASETS/feature-classifier-extract-reads/ref-seqs.qza

qiime feature-classifier fit-classifier-naive-bayes \
    --i-reference-reads $DATASETS/feature-classifier-extract-reads/ref-seqs.qza \
    --i-reference-taxonomy $DATASETS/tools-import/ref-taxonomy.qza \
    --o-classifier $DATASETS/feature-classifier-fit-classifier-naive-bayes/classifier.qza
