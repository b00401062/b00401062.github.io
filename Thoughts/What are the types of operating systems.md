# What are the types of operating systems?

An operating system (OS) may come with a graphical user interface or not, but the kernel, the heart that confers its authority, is consistently existent. Its architecture varies based on the extent of its codes inhabiting kernel space or user space. On the two ends of the spectrum are microkernel and monolithic kernel. Any designs located in between are termed a hybrid.

First off, microkernel retains only components that must dwell in a privileged mode such that its integrity is warranted. These components, although scientists have yet to reach a consensus, comprise (1) CPU clock, (2) process/thread management, and (3) synchronization. Since these components are so imperative that hardware also aids in their implementation. Microkernel advocates the reusability of each component via extraordinary modularity. File service, device drivers, etc, are each wrapped into a standalone piece of the whole puzzle. Standardized APIs are provided to allow for putting all pieces together to build an application. The interaction of each module is coordinated and scrutinized by the kernel.

In contrast to the microkernel, the monolithic kernel implements all components in the kernel space by stacking them up in a hierarchical manner. A user application invokes a system call to use specific functionality provided by the kernel. In this way, the user application is believed to execute more efficiently since these codes run directly in the kernel space without the kernel's coordination.

To summarize, the two major types of operating systems, microkernel and monolithic kernel, differ in the components running in the kernel space. If is safe to say that both designs have their pros and cons and have, therefore, a niche in the market.
