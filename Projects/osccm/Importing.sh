#!/usr/bin/env bash

qiime tools import \
    --type "SampleData[PairedEndSequencesWithQuality]" \
    --input-path $DATASETS/metadata/manifest.csv \
    --input-format PairedEndFastqManifestPhred33 \
    --output-path $DATASETS/tools-import/demux.qza

qiime demux summarize \
    --i-data $DATASETS/tools-import/demux.qza \
    --o-visualization $DATASETS/visualization/demux-summarize.qzv
