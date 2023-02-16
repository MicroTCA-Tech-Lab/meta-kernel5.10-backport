# https://github.com/Xilinx/linux-xlnx/releases/tag/xlnx_rebase_v5.10_2021.1

require recipes-kernel/linux/linux-xlnx.inc

LINUX_VERSION = "5.10"
SRCREV = "c830a552a6c34931352afd41415a2e02cca3310d"
KBRANCH = "xlnx_rebase_v5.10"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LICENSE = "GPLv2"
PROVIDES += "virtual/kernel"

# Make kernel 5.10 build with Yocto Zeus aka. petalinux 2020.2

# Revert the 5.10 change that breaks the Yocto kernel build scripts
SRC_URI_append = " file://0001-Revert-kbuild-preprocess-module-linker-script.patch"

# Kernel 5.10 does not generate Module.symvers anymore. Make kernel.bbclass happy by faking one
do_shared_workdir_prepend () {
    touch ${B}/Module.symvers
}

do_shared_workdir_append () {
    rm $kerneldir/Module.symvers
}
