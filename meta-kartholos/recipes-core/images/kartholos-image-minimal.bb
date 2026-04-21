SUMMARY = "KartholOS Minimal Console Image"
DESCRIPTION = "A basic console-only Linux image for KartholOS, focused on stability and speed."
LICENSE = "MIT"

inherit core-image

# Enable SSH and bootable live ISO
IMAGE_FEATURES += "ssh-server-openssh"

# Minimal package set
IMAGE_INSTALL += " \
    packagegroup-core-boot \
    os-release \
    base-files \
"

# Generate a bootable ISO image
IMAGE_FSTYPES += "iso live"

# Keep it lean
IMAGE_OVERHEAD_FACTOR = "1.2"
