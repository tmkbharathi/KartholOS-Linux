SUMMARY = "KartholOS Custom Qt6 Shell"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase qtdeclarative"
RDEPENDS:${PN} += "qtwayland"

# The files are now located in the subdirectory 'files' relative to this recipe
SRC_URI = "file://main.cpp \
           file://main.qml \
           file://CMakeLists.txt"

S = "${WORKDIR}"

inherit qt6-cmake

# Note: No 'do_install' is needed because our CMakeLists.txt handles installation.
