# KartholOS Linux

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Build Status](https://github.com/tmkbharathi/KartholOS-Linux/actions/workflows/build-kartholos.yml/badge.svg)

**KartholOS** is a custom Linux distribution built on the **Yocto Project (Scarthgap)**. Currently, the project is focused on providing a clean, stable, and high-performance **minimal Linux base** (CLI-only) that serves as the foundation for future development.

## 🚀 Key Features

- **Architected with Yocto**: Custom metadata layer (`meta-kartholos`) for full control over the distribution.
- **Minimalist Foundation**: CLI-only build for maximum stability and reduced resource usage.
- **Fast Development Cycle**: Optimized build system that completes in minutes, not hours.
- **Robust Init System**: Powered by **systemd** for modern service management and fast boot times.
- **Cloud-Ready CI/CD**: Fully automated build pipeline using GitHub Actions with optimized disk and resource management.

## 🛠 Tech Stack

| Component | Technology |
| :--- | :--- |
| **Kernel** | Linux Kernel (LTS) |
| **Build System** | Yocto Project (Scarthgap) |
| **Architecture** | x86_64 |
| **Init System** | systemd |
| **Package Manager** | opkg / rpm (customizable) |
| **Build CI** | GitHub Actions |

## 📁 Repository Structure

```text
.
├── meta-kartholos/      # Custom Yocto Layer (Branding, Recipes, Images)
├── .github/
│   └── workflows/      # GitHub Actions Build Pipeline (Optimized)
└── README.md
```

## 🏗 Building KartholOS

### Cloud Build (Recommended)
This repository is configured with a high-performance GitHub Actions workflow. Simply push changes to the `main` branch, and the **Build KartholOS** runner will:
1. Initialize the Poky build environment.
2. Reclaim ~100GB of disk space for a stable build.
3. Execute `bitbake kartholos-image-minimal`.
4. Upload a bootable `.iso` artifact.

### Local Build (Linux/WSL)
*Note: Requires ~50GB disk space and 8GB+ RAM.*
1. Install Yocto dependencies.
2. Clone Poky (scarthgap) and meta-openembedded.
3. `source poky/oe-init-build-env build`
4. Add `meta-kartholos` and dependencies to `conf/bblayers.conf`.
5. Run `bitbake kartholos-image-minimal`.

## 🖥 Running KartholOS

### Automatic Boot (Yocto Environment)
If you have the full Yocto environment set up, use the built-in helper:
```bash
runqemu qemux86-64
```

### Manual Boot (Windows / QEMU)
If you have downloaded the `.iso` and want to run it directly using QEMU on Windows, use the following commands:

**Standard Boot (Performance Mode):**
```powershell
qemu-system-x86_64 -m 1G -accel whpx,kernel-irqchip=off -cpu Westmere -device virtio-scsi-pci -device scsi-cd,drive=cd0 -drive file=out/kartholos-image-minimal-qemux86-64.rootfs.iso,if=none,id=cd0 -serial stdio
```

**Debug Mode (Enable Log Copying):**
To copy boot logs, use the command above and select **"Serial console boot"** from the blue GRUB menu. The logs will stream to your terminal where they can be selected and copied.

**Safe Mode (No Acceleration):**
If hardware acceleration crashes, use this slower but stable command:
```powershell
qemu-system-x86_64 -m 1G -cdrom out/kartholos-image-minimal-qemux86-64.rootfs.iso -serial stdio
```

Access is available via the local console or SSH (if configured).

## 🗺 Roadmap
- [x] Establish minimal Linux foundation
- [x] Optimize CI build stability
- [ ] Add lightweight shell (Slint/LVGL)
- [ ] Implement custom GUI (Qt6/Wayland)
- [ ] Hardware-specific optimizations

## 👤 Author
**Manikanda Bharathi T**
- GitHub: [@tmkbharathi](https://github.com/tmkbharathi)

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
