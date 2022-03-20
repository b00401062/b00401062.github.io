#!/usr/bin/env bash

for l in {1..7}
do
    qiime feature-table relative-frequency \
        --i-table $DATASETS/taxa-collapse/table-l$l-hmp.qza \
        --o-relative-frequency-table $DATASETS/feature-table-relative-frequency/table-l$l-hmp.qza
    qiime tools export \
        --input-path $DATASETS/feature-table-relative-frequency/table-l$l-hmp.qza \
        --output-path $DATASETS/tools-export/table-l$l-hmp
    biom convert \
        -i $DATASETS/tools-export/table-l$l-hmp/feature-table.biom \
        -o $DATASETS/tools-export/table-l$l-hmp/feature-table.tsv \
        --to-tsv
done
