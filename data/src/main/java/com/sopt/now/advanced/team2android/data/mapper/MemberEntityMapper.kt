package com.sopt.now.advanced.team2android.data.mapper

import com.sopt.now.advanced.team2android.data.model.Member
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity

fun MemberEntity.toMember() = Member(
    id = this.id,
    pw = this.pw,
    nickname = this.nickname
)