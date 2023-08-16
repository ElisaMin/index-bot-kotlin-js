package com.tgse.index.domain.service

import com.tgse.index.domain.repository.ClassificationRepository
import org.springframework.stereotype.Service

@Service
class ClassificationService(
    private val classificationRepository: ClassificationRepository
) {

    val classifications: Array<String>
        get() = classificationRepository.classifications

    fun contains(classification: String): Boolean {
        return classificationRepository.contains(classification)
    }

    fun add(classification: String): Boolean {
        return classificationRepository.add(classification)
    }

    fun remove(classification: String): Boolean {
        return classificationRepository.remove(classification)
    }

}