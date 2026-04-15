FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_install:append() {
    echo "KartholOS" > ${D}${sysconfdir}/hostname
}
