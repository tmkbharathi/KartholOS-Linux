SUMMARY = "KartholOS Custom Qt6 Shell"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase qtdeclarative"
RDEPENDS:${PN} += "qtwayland"

SRC_URI = "file://main.cpp \
           file://main.qml \
           file://CMakeLists.txt"

S = "${WORKDIR}"

inherit qt6-cmake

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 kartholos_shell ${D}${bindir}
}
