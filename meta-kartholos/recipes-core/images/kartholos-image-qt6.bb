SUMMARY = "KartholOS High-Performance Qt6/Wayland Image"
DESCRIPTION = "The primary operating system image for KartholOS, featuring a custom Qt6 UI."

LICENSE = "MIT"

inherit core-image

# Core features
IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs"

# Distro features to include
DISTRO_FEATURES:append = " wayland opengl systemd"

# Packages to install
IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    \
    qtbase \
    qtdeclarative \
    qtwayland \
    \
    weston \
    weston-init \
    \
    kartholos-shell \
    \
    os-release \
    base-files \
"

# Set systemd as the default init manager
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

# Ensure we have enough space for Qt
IMAGE_OVERHEAD_FACTOR = "1.5"
IMAGE_ROOTFS_SIZE = "524288" 
