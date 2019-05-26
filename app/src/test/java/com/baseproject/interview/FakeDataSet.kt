package com.baseproject.interview

import com.babylon.mesquita.interview.data.Feature

fun listOfFeature(): MutableList<Feature> {
    val features = mutableListOf<Feature>()
    for (i in 1..10) {
        val feature = Feature("200", "douglas")
        features.add(feature)
    }
    return features
}