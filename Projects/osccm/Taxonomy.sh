#!/usr/bin/env bash

qiime feature-classifier classify-sklearn \
    --i-classifier $DATASETS/feature-classifier-fit-classifier-naive-bayes/classifier.qza \
    --i-reads $DATASETS/dada2-denoise-paired/rep-seqs.qza \
    --o-classification $DATASETS/feature-classifier-classify-sklearn/taxonomy.qza

qiime metadata tabulate \
    --m-input-file $DATASETS/feature-classifier-classify-sklearn/taxonomy.qza \
    --o-visualization $DATASETS/visualization/metadata-tabulate-taxonomy.qzv

qiime taxa barplot \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --i-taxonomy $DATASETS/feature-classifier-classify-sklearn/taxonomy.qza \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --o-visualization $DATASETS/visualization/taxa-barplot.qzv
