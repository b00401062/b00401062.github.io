#!/usr/bin/env bash

qiime phylogeny align-to-tree-mafft-fasttree \
    --i-sequences $DATASETS/dada2-denoise-paired/rep-seqs.qza \
    --o-alignment $DATASETS/phylogeny-align-to-tree-mafft-fasttree/aligned-rep-seqs.qza \
    --o-masked-alignment $DATASETS/phylogeny-align-to-tree-mafft-fasttree/masked-aligned-rep-seqs.qza \
    --o-tree $DATASETS/phylogeny-align-to-tree-mafft-fasttree/unrooted-tree.qza \
    --o-rooted-tree $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.qza

qiime tools export \
    --input-path $DATASETS/phylogeny-align-to-tree-mafft-fasttree/unrooted-tree.qza \
    --output-path $DATASETS/phylogeny-align-to-tree-mafft-fasttree

mv $DATASETS/phylogeny-align-to-tree-mafft-fasttree/tree.nwk $DATASETS/phylogeny-align-to-tree-mafft-fasttree/unrooted-tree.nwk

qiime tools export \
    --input-path $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.qza \
    --output-path $DATASETS/phylogeny-align-to-tree-mafft-fasttree

mv $DATASETS/phylogeny-align-to-tree-mafft-fasttree/tree.nwk $DATASETS/phylogeny-align-to-tree-mafft-fasttree/rooted-tree.nwk
