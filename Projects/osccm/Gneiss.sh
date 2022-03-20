#!/usr/bin/env bash

qiime gneiss ilr-phylogenetic \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --i-tree $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.qza \
    --o-balances $DATASETS/gneiss-ilr-phylogenetic/balances.qza \
    --o-hierarchy $DATASETS/gneiss-ilr-phylogenetic/hierarchy.qza

qiime gneiss ols-regression \
    --p-formula Tissue \
    --i-table $DATASETS/gneiss-ilr-phylogenetic/balances.qza \
    --i-tree $DATASETS/gneiss-ilr-phylogenetic/hierarchy.qza \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --o-visualization $DATASETS/visualization/gneiss-ols-regression.qzv
