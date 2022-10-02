package com.evanross.randomapex.model

import androidx.annotation.DrawableRes

data class ApexGun(
    @DrawableRes val iconArtImageId: Int,
    val name: String,
    val id: Int,
    val primaryAmmoType: String,
    val gunClass: String,
    val secondaryAmmoType: String? = null,
    val carePackageGun: Boolean = false
)
/*

3030repeater,
a13sentry,
alternator,
bocek,
car,
charge_rifle,
devotion,
eva8,
flatline,
g7_scout,
havoc,
hemlock,
kraber,
longbow,
lstar,
mastiff,
mozambique,
p2020,
peacekeeper,
prowler,
r99,
r301,
rampage,
re45,
sentinal,
spitfire,
triple_take,
volt,
wingman,


 */