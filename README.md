# meta-techlab-kernel-backport

This is a [mixin layer](https://wiki.yoctoproject.org/wiki/Stable_Release_and_LTS#LTS_.E2.80.9CMixin.E2.80.9D_repositories) to add a backport of Linux 5.10 to Xilinx Petalinux 2020.2 based Yocto projects. It uses the [`xlnx_rebase_v5.10_2021.1`](https://github.com/Xilinx/linux-xlnx/releases/tag/xlnx_rebase_v5.10_2021.1) branch of [linux-xlnx](https://github.com/Xilinx/linux-xlnx).

To switch between kernel versions, use `PREFERRED_VERSION` (e.g. in `local.conf`):
```bash
# Use 5.4
PREFERRED_VERSION_linux-xlnx = "5.4+%"

# Use 5.10
PREFERRED_VERSION_linux-xlnx = "5.10+%"
```
