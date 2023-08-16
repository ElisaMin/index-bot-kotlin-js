@file:Suppress("PropertyName")

package com.github.kotlintelegrambot.entities

data class ChatMember(
    val user: User,
    val status: String,
    val custom_title: String? = null,
    val is_anonymous: Boolean? = null,
    val until_date: Int? = null,
    val can_be_edited: Boolean? = null,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_delete_messages: Boolean? = null,
    val can_restrict_members: Boolean? = null,
    val can_promote_members: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_pin_messages: Boolean? = null,
    val is_member: Boolean? = null,
    val can_send_messages: Boolean? = null,
    val can_send_media_messages: Boolean? = null,
    val can_send_polls: Boolean? = null,
    val can_send_other_messages: Boolean? = null,
    val can_add_web_page_previews: Boolean? = null,
)
