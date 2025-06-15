package com.brafik.famous.features.drafts.domain

import com.brafik.famous.features.drafts.data.DraftDao
import com.brafik.famous.features.drafts.data.DraftEntity
import kotlinx.uuid.UUID

class SaveDraftUseCase(
    private val draftDao: DraftDao
) {
    suspend fun execute(title: String, text: String) {
        draftDao.insert(
            DraftEntity(
                draftId = UUID().toString(false),
                title = title,
                text = text
            )
        )
    }
}