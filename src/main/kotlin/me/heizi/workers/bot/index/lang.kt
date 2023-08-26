package me.heizi.workers.bot.index

import kotlin.reflect.KProperty1

private data object DefaultReplies:CustomReplies {
    override val start: String = "欢迎使用本机器人"
    override val groupBotAuthority: String = "机器人权限不足"
    override val groupUserAuthority: String = "用户权限不足"
    override val groupAnonymousAuthority: String = "匿名用户权限不足"
    override val groupNotEnroll: String = "未加入群组"
    override val groupEnrollerFail: String = "加入群组失败"
    override val enroll: String = "加入群组"
    override val enrollNeedJoinGroup: String = "请先加入群组"
    override val updateLink: String = "更新链接"
    override val updateLinkGroup: String = "更新群组链接"
    override val updateTitle: String = "更新标题"
    override val updateAbout: String = "更新关于"
    override val updateTags: String = "更新标签"
    override val updateCategory: String = "更新分类"
    override val enrollSubmitVerifyClassification: String = "提交审核分类"
    override val enrollSubmit: String = "提交审核"
    override val enrollSucceeded: String = "加入成功"
    override val enrollFailed: String = "加入失败"
    override val recordRemoved: String = "记录已移除"
    override val nothing: String = "无"
    override val setting: String = "设置"
    override val helpPrivate: String = "私聊帮助"
    override val helpGroup: String = "群组帮助"
    override val canNotUnderstand: String = "无法理解"
    override val cancel: String = "取消"
    override val onlyGroup: String = "仅限群组"
    override val onlyPrivate: String = "仅限私聊"
    override val disable: String = "已禁用"
    override val plsCheckPrivate: String = "请私聊"
    override val blacklistJoin: String = "加入黑名单"
    override val blacklistLeft: String = "离开黑名单"
    override val blacklistExistUser: String = "用户已在黑名单"
    override val blacklistExistRecord: String = "记录已在黑名单"
    override val feedbackStart: String = "反馈开始"
    override val feedbackFinish: String = "反馈结束"
    override val removeRecordManager: String = "移除记录"
    override val removeRecordUser: String = "移除记录"
    override val statisticsDaily: String = "统计日报"
    override val exist: String = "存在"
    override val banParameter: String = "参数错误"
    override val banSuccess: String = "已加入黑名单"
    override val unbanParameter: String = "参数错误"
    override val unbanNoNeed: String = "不在黑名单"
    override val unbanSuccess: String = "已移出黑名单"
    override val empty: String = "空"
    override val error: String = "错误"
    override val await: String = "等待"
    override val awaitFailed = "请求超过十五分钟或者已经提交过了"
    override val updateCategorySuccess: String = "分类更新成功: {{category}}"

}

interface CustomReplies {
    companion object {
        operator fun invoke(block:CustomReplies.()->KProperty1<CustomReplies, String?>) = get(block(DefaultReplies))
        operator fun get(property:KProperty1<CustomReplies, String?>):String {
            return contextGlobal.customReplies?.let(property) ?: property(DefaultReplies)!!
        }

    }

    val start:String?
    val groupBotAuthority:String?
    val groupUserAuthority:String?
    val groupAnonymousAuthority:String?
    val groupNotEnroll:String?
    val groupEnrollerFail:String?
    val enroll:String?
    val enrollNeedJoinGroup:String?

    val updateLink:String?
    val updateLinkGroup:String?
    val updateTitle:String?
    val updateAbout:String?
    val updateTags:String?
    val updateCategory:String? //new

    val enrollSubmitVerifyClassification:String?
    val enrollSubmit:String?
    val enrollSucceeded:String?
    val enrollFailed:String?
    val recordRemoved:String?
    val nothing:String?
    val setting:String?
    val helpPrivate:String?
    val helpGroup:String?
    val canNotUnderstand:String?
    val cancel:String?
    val onlyGroup:String?
    val onlyPrivate:String?
    val disable:String?
    val plsCheckPrivate:String?
    val blacklistJoin:String?
    val blacklistLeft:String?
    val blacklistExistUser:String?
    val blacklistExistRecord:String?
    val feedbackStart:String?
    val feedbackFinish:String?
    val removeRecordManager:String?
    val removeRecordUser:String?
    val statisticsDaily:String?
    val exist:String?
    val banParameter:String?
    val banSuccess:String?
    val unbanParameter:String?
    val unbanNoNeed:String?
    val unbanSuccess:String?
    val empty:String?
    val error:String?
    val await:String?
    val awaitFailed: String?

    val updateCategorySuccess:String?
}