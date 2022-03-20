#!/usr/bin/env python

from keras.preprocessing.image import ImageDataGenerator
from keras.applications.xception import Xception
from keras.layers import Dense, Flatten
from keras.models import Model
from keras.callbacks import EarlyStopping
from keras.callbacks import ModelCheckpoint


class Classifier:
    def __init__(self, PREPROCESSEDDIR, S):
        self.PREPROCESSEDDIR = PREPROCESSEDDIR
        self.S = S

    def fit(self, LABELS):
        generator = ImageDataGenerator(
            rotation_range=90,
            zoom_range=0.2,
            brightness_range=(0.5, 2),
            width_shift_range=0.2,
            height_shift_range=0.2,
            horizontal_flip=True,
        )
        self.model = Xception(weights="imagenet", include_top=False, input_shape=(self.S, self.S, 3))
        for layer in self.model.layers:
            layer.trainable = False
        outputs = Dense(105, activation="softmax")(Flatten()(self.model.output))
        self.model = Model(inputs=self.model.input, outputs=outputs)
        self.model.compile(loss="categorical_crossentropy", optimizer="adam", metrics=["accuracy"])
        self.model.summary()
        self.model.fit_generator(
            generator=generator.flow_from_dataframe(
                dataframe=LABELS.training,
                directory=self.PREPROCESSEDDIR,
                target_size=(self.S, self.S),
                x_col="ImageID",
                y_col="Label",
            ),
            epochs=100,
            verbose=1,
            callbacks=[
                EarlyStopping(monitor="val_loss", patience=4),
                ModelCheckpoint(filepath="Classifier.h5", monitor="val_loss", save_best_only=True)
            ],
            validation_data=generator.flow_from_dataframe(
                dataframe=LABELS.test,
                directory=self.PREPROCESSEDDIR,
                target_size=(self.S, self.S),
                x_col="ImageID",
                y_col="Label",
            ),
            use_multiprocessing=True,
        )
        return self

    def predict(self, LABELS):
        self.model.predict_generator(
            generator=ImageDataGenerator().flow_from_dataframe(
                dataframe=LABELS,
                directory=self.PREPROCESSEDDIR,
                target_size=(self.S, self.S),
                x_col="ImageID",
                y_col="Label",
            ),
        )
