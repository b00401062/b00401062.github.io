#!/usr/bin/env python

from collections import namedtuple

Name = namedtuple("Name", ["Nickname", "Fullname"])
Set = namedtuple("Set", ["Training", "Test"])
Course = namedtuple("Course", ["Chronic", "Early"])
Category = namedtuple("Category", ["NR", "R"])
Best = namedtuple("Best", ["Index", "Parameter", "Mean", "SD"])
Outcome = namedtuple("Outcome", ["Actual", "Predicted"])
Result = namedtuple("Result", ["Accuracy", "Sensitivity", "Specificity", "PPV", "NPV"])
Model = namedtuple("Model", [
    "LinearDiscriminantAnalysis", ## linear discriminant analysis (LDA)
    "QuadraticDiscriminantAnalysis", ## quadratic discriminant analysis (QDA)
    "LogisticRegression", ## logistic regression (LR)
    "SVC" ## support vector classifier (SVC)
])

COLUMNS = ["File", "Age", "Sex", "Duration", "Dose", "P1", "P2", "P3", "N1", "N4", "N6", "G5", "G9"]
INDICES = ["FA", "GFA", "AD", "RD", "MD", "NG", "NGO", "NGP"]
TRACTS = (
    Name(Nickname = "T001_AF_L", Fullname = "Left arcuate fasciculus"),
    Name(Nickname = "T002_AF_R", Fullname = "Right arcuate fasciculus"),
    Name(Nickname = "T003_CG_body_L", Fullname = "Left cingulum main body part"),
    Name(Nickname = "T004_CG_body_R", Fullname = "Right cingulum main body part"),
    Name(Nickname = "T005_CG_hippocampal_L", Fullname = "Left cingulum hippocampal part"),
    Name(Nickname = "T006_CG_hippocampal_R", Fullname = "Right cingulum hippocampal part"),
    Name(Nickname = "T007_Frontal_aslent_tract_L", Fullname = "Left frontal aslant tract"),
    Name(Nickname = "T008_Frontal_aslent_tract_R", Fullname = "Right frontal aslant tract"),
    Name(Nickname = "T009_FX_L", Fullname = "Left fornix"),
    Name(Nickname = "T010_FX_R", Fullname = "Right fornix"),
    Name(Nickname = "T011_IFOF_L", Fullname = "Left inferior fronto-occipital fasciculus"),
    Name(Nickname = "T012_IFOF_R", Fullname = "Right inferior fronto-occipital fasciculus"),
    Name(Nickname = "T013_ILF_L", Fullname = "Left inferior longitudinal fasciculus"),
    Name(Nickname = "T014_ILF_R", Fullname = "Right inferior longitudinal fasciculus"),
    Name(Nickname = "T015_Perpendicular_fasciculus_L", Fullname = "Left perpendicular fasciculus"),
    Name(Nickname = "T016_Perpendicular_fasciculus_R", Fullname = "Right perpendicular fasciculus"),
    Name(Nickname = "T017_SLF1_L", Fullname = "Left superior longitudinal fasciculus I"),
    Name(Nickname = "T018_SLF1_R", Fullname = "Right superior longitudinal fasciculus I"),
    Name(Nickname = "T019_SLF2_L", Fullname = "Left superior longitudinal fasciculus II"),
    Name(Nickname = "T020_SLF2_R", Fullname = "Right superior longitudinal fasciculus II"),
    Name(Nickname = "T021_SLF3_L", Fullname = "Left superior longitudinal fasciculus III"),
    Name(Nickname = "T022_SLF3_R", Fullname = "Right superior longitudinal fasciculus III"),
    Name(Nickname = "T023_stria_terminalis_L", Fullname = "Left stria terminalis"),
    Name(Nickname = "T024_stria_terminalis_R", Fullname = "Right stria terminalis"),
    Name(Nickname = "T025_UF_L", Fullname = "Left uncinate fasciculus"),
    Name(Nickname = "T026_UF_R", Fullname = "Right uncinate fasciculus"),
    Name(Nickname = "T027_CST_HAND_L", Fullname = "Left corticospinal tract of hand"),
    Name(Nickname = "T028_CST_HAND_R", Fullname = "Right corticospinal tract of hand"),
    Name(Nickname = "T029_CST_M1_L", Fullname = "Left corticospinal tract of trunk"),
    Name(Nickname = "T030_CST_M1_R", Fullname = "Right corticospinal tract of trunk"),
    Name(Nickname = "T031_CST_mouth_L", Fullname = "Left corticospinal tract of mouth"),
    Name(Nickname = "T032_CST_mouth_R", Fullname = "Right corticospinal tract of mouth"),
    Name(Nickname = "T033_CST_toe_L", Fullname = "Left corticospinal tract of toe"),
    Name(Nickname = "T034_CST_toe_R", Fullname = "Right corticospinal tract of toe"),
    Name(Nickname = "T035_Geniculate_fibers_L", Fullname = "Left corticospinal tract of geniculate fibers"),
    Name(Nickname = "T036_Geniculate_fibers_R", Fullname = "Right corticospinal tract of geniculate fibers"),
    Name(Nickname = "T037_FS_OFC_L", Fullname = "Left frontostriatal tract of orbitofrontal cortex"),
    Name(Nickname = "T038_FS_OFC_R", Fullname = "Right frontostriatal tract of orbitofrontal cortex"),
    Name(Nickname = "T039_FS_VLPFC_L", Fullname = "Left frontostriatal tract of ventral lateral prefrontal cortex"),
    Name(Nickname = "T040_FS_VLPFC_R", Fullname = "Right frontostriatal tract of ventral lateral prefrontal cortex"),
    Name(Nickname = "T041_FS_DLPFC_L", Fullname = "Left frontostriatal tract of dorsolateral prefrontal cortex"),
    Name(Nickname = "T042_FS_DLPFC_R", Fullname = "Right frontostriatal tract of dorsolateral prefrontal cortex"),
    Name(Nickname = "T043_FS_motor_precentral_L", Fullname = "Left frontostriatal tract of precentral gyrus"),
    Name(Nickname = "T044_FS_motor_precentral_R", Fullname = "Right frontostriatal tract of precentral gyrus"),
    Name(Nickname = "T045_Medial_lemniscus_L", Fullname = "Left medial lemniscus"),
    Name(Nickname = "T046_Medial_lemniscus_R", Fullname = "Right medial lemniscus"),
    Name(Nickname = "T047_TR_ventral_L", Fullname = "Left thalamic radiation of ventral lateral prefrontal cortex"),
    Name(Nickname = "T048_TR_ventral_R", Fullname = "Right thalamic radiation of ventral lateral prefrontal cortex"),
    Name(Nickname = "T049_TR_dorsal_L", Fullname = "Left thalamic radiation of dorsolateral prefrontal cortex"),
    Name(Nickname = "T050_TR_dorsal_R", Fullname = "Right thalamic radiation of dorsolateral prefrontal cortex"),
    Name(Nickname = "T051_TR_precentral_L", Fullname = "Left thalamic radiation of precentral gyrus"),
    Name(Nickname = "T052_TR_precentral_R", Fullname = "Right thalamic radiation of precentral gyrus"),
    Name(Nickname = "T053_TR_postcentral_L", Fullname = "Left thalamic radiation of postcentral gyrus"),
    Name(Nickname = "T054_TR_postcentral_R", Fullname = "Right thalamic radiation of postcentral gyrus"),
    Name(Nickname = "T055_TR_auditory_L", Fullname = "Left thalamic radiation of auditory nerve"),
    Name(Nickname = "T056_TR_auditory_R", Fullname = "Right thalamic radiation of auditory nerve"),
    Name(Nickname = "T057_TR_optic_L", Fullname = "Left thalamic radiation of optic radiation"),
    Name(Nickname = "T058_TR_optic_R", Fullname = "Right thalamic radiation of optic radiation"),
    Name(Nickname = "T059_AC", Fullname = "Anterior commissure"),
    Name(Nickname = "T060_PC", Fullname = "Posterior commissure"),
    Name(Nickname = "T061_CC_gen", Fullname = "Corpus callosum of genus"),
    Name(Nickname = "T062_CC_DLPFC", Fullname = "Corpus callosum of dorsolateral prefrontal cortex"),
    Name(Nickname = "T063_CC_VLPFC", Fullname = "Corpus callosum of ventral lateral prefrontal cortex"),
    Name(Nickname = "T064_CC_SMA", Fullname = "Corpus callosum of supplementary motor area"),
    Name(Nickname = "T065_CC_motor_precentral", Fullname = "Corpus callosum of precentral gyrus"),
    Name(Nickname = "T066_CC_paracentral", Fullname = "Corpus callosum of paracentral lobule"),
    Name(Nickname = "T067_CC_inferior_parietal_lobule", Fullname = "Corpus callosum of inferior parietal lobule"),
    Name(Nickname = "T068_CC_postcentral_dorsal", Fullname = "Corpus callosum of postcentral gyrus"),
    Name(Nickname = "T069_CC_superior_parietal_lobule", Fullname = "Corpus callosum of superior parietal lobule"),
    Name(Nickname = "T070_CC_supeior_temporal", Fullname = "Corpus callosum of superior temporal gyrus"),
    Name(Nickname = "T071_CC_middle_temporal", Fullname = "Corpus callosum of middle temporal gyrus"),
    Name(Nickname = "T072_CC_temporal_pole", Fullname = "Corpus callosum of temporal pole"),
    Name(Nickname = "T073_CC_hippocampus", Fullname = "Corpus callosum of hippocampus"),
    Name(Nickname = "T074_CC_amygdala", Fullname = "Corpus callosum of amygdala"),
    Name(Nickname = "T075_CC_precuneus", Fullname = "Corpus callosum of precuneus"),
    Name(Nickname = "T076_CC_splenium", Fullname = "Corpus callosum of splenium")
)
FEATURES = (lambda: ["_".join([index, tract.Nickname, str(step)]) for index in INDICES for tract in TRACTS for step in range(100)])()
