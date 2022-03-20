#!/usr/bin/env bash

## Alpha Rarefaction

qiime diversity alpha-rarefaction \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --i-phylogeny $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.qza \
    --p-max-depth 10635 \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --o-visualization $DATASETS/visualization/diversity-alpha-rarefaction.qzv

## Preprocessing

qiime diversity core-metrics-phylogenetic \
    --i-phylogeny $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.qza \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --p-sampling-depth 1006 \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --output-dir $DATASETS/diversity-core-metrics-phylogenetic

## Alpha Diversity

qiime diversity alpha-group-significance \
    --i-alpha-diversity $DATASETS/diversity-core-metrics-phylogenetic/shannon_vector.qza \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --o-visualization $DATASETS/visualization/diversity-alpha-group-significance.qzv

## Beta Diversity

qiime diversity beta-group-significance \
    --i-distance-matrix $DATASETS/diversity-core-metrics-phylogenetic/unweighted_unifrac_distance_matrix.qza \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --m-metadata-column Tissue \
    --o-visualization $DATASETS/visualization/diversity-beta-group-significance.qzv \
    --p-pairwise
