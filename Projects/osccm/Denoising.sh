#!/usr/bin/env bash

qiime dada2 denoise-paired \
    --i-demultiplexed-seqs $DATASETS/tools-import/demux.qza \
    --p-trunc-len-f 0 \
    --p-trunc-len-r 0 \
    --p-trunc-q 20 \
    --p-n-threads 0 \
    --o-table $DATASETS/dada2-denoise-paired/table.qza \
    --o-representative-sequences $DATASETS/dada2-denoise-paired/rep-seqs.qza \
    --o-denoising-stats $DATASETS/dada2-denoise-paired/denoising-stats.qza

qiime feature-table summarize \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --m-sample-metadata-file $DATASETS/metadata/metadata.tsv \
    --o-visualization $DATASETS/visualization/feature-table-summarize.qzv

qiime feature-table tabulate-seqs \
    --i-data $DATASETS/dada2-denoise-paired/rep-seqs.qza \
    --o-visualization $DATASETS/visualization/feature-table-tabulate-seqs.qzv

qiime metadata tabulate \
    --m-input-file $DATASETS/dada2-denoise-paired/denoising-stats.qza \
    --o-visualization $DATASETS/visualization/metadata-tabulate-denoising-stats.qzv
