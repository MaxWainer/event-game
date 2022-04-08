package ru.mgkit.event.game.objects

import kotlinx.serialization.Serializable

@Serializable
sealed class QuestData : Displayable {

    @Serializable
    data class Description(val description: String, override val displayName: String) : QuestData()

    @Serializable
    data class AnswerSet(val answers: Set<Answer>, override val displayName: String) : QuestData()

    @Serializable
    data class Answer(val right: Boolean, override val displayName: String) : QuestData()

}
