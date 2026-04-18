SUMMARY = "KartholOS Minimal Console Image"
DESCRIPTION = "A basic console-only Linux image for KartholOS, focused on stability and speed."
LICENSE = "MIT"

inherit core-image

# Core features: boot, serial console, and SSH for remote access
IMAGE_FEATURES += "ssh-server-openssh"

# Minimal package set
IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    os-release \
    base-files \
"

# Set systemd as the default init manager
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

# Keep it lean
IMAGE_OVERHEAD_FACTOR = "1.2"
IMAGE_ROOTFS_SIZE = "65536" 

# Generate a bootable ISO image
IMAGE_FSTYPES:append = " iso"
