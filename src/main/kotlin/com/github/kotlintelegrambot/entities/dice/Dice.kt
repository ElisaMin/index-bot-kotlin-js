package com.github.kotlintelegrambot.entities.dice

/**
 * Represents an animated emoji that displays a random value.
 * https://core.telegram.org/bots/api#dice
 */
data class Dice(
    val emoji: DiceEmoji,
    val value: Int,
)

sealed class DiceEmoji {
    abstract val emojiValue: String

    data object Dice : DiceEmoji() {
        override val emojiValue: String
            get() = "🎲"
    }

    data object Dartboard : DiceEmoji() {
        override val emojiValue: String
            get() = "🎯"
    }

    data object Basketball : DiceEmoji() {
        override val emojiValue: String
            get() = "🏀"
    }

    data object Football : DiceEmoji() {
        override val emojiValue: String
            get() = "⚽️"
    }

    data object SlotMachine : DiceEmoji() {
        override val emojiValue: String
            get() = "🎰"
    }

    data object Bowling : DiceEmoji() {
        override val emojiValue: String
            get() = "🎳"
    }

    // Currently not supported, adding it just in case Telegram Bot API
    // starts supporting new emojis for the dice in the future
    data class Other(override val emojiValue: String) : DiceEmoji()

    companion object {
        fun fromString(emoji: String): DiceEmoji = when (emoji) {
            Dice.emojiValue -> Dice
            Dartboard.emojiValue -> Dartboard
            Basketball.emojiValue -> Basketball
            Football.emojiValue -> Football
            SlotMachine.emojiValue -> SlotMachine
            Bowling.emojiValue -> Bowling
            else -> Other(emoji)
        }
    }
}
