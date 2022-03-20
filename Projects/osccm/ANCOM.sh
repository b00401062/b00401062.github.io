#!/usr/bin/env bash

qiime composition add-pseudocount \
    --i-table $DATASETS/dada2-denoise-paired/table.qza \
    --o-composition-table $DATASETS/composition-add-pseudocount/comp-table.qza

qiime composition ancom \
    --i-table $DATASETS/composition-add-pseudocount/comp-table.qza \
    --m-metadata-file $DATASETS/metadata/metadata.tsv \
    --m-metadata-column Tissue \
    --o-visualization $DATASETS/visualization/composition-ancom.qzv

for l in {1..7}
do
    qiime taxa collapse \
        --i-table $DATASETS/dada2-denoise-paired/table.qza \
        --i-taxonomy $DATASETS/feature-classifier-classify-sklearn/taxonomy.qza \
        --p-level $l \
        --o-collapsed-table $DATASETS/taxa-collapse/table-l$l.qza

    qiime composition add-pseudocount \
        --i-table $DATASETS/taxa-collapse/table-l$l.qza \
        --o-composition-table $DATASETS/composition-add-pseudocount/comp-table-l$l.qza


    qiime composition ancom \
        --i-table $DATASETS/composition-add-pseudocount/comp-table-l$l.qza \
        --m-metadata-file $DATASETS/metadata/metadata.tsv \
        --m-metadata-column Tissue \
        --o-visualization $DATASETS/visualization/composition-ancom/composition-ancom-l$l.qzv
done
