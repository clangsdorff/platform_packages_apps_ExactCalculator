#Calculator

A fork of the GrapheneOS Exact Calculator app, built as an Android application using the Android Soong build system.

This project is a calculator designed around exact arithmetic rather than conventional floating-point math. It includes a Java implementation and a separate `crcalc` library for constructive real-number calculations, along with documentation in the `docs/` directory.

## Overview

The app is packaged as:

- `com.android.calculator2`
- Module name: `ExactCalculator`

The repository includes:

- `src/` — Android app source code
- `res/` — UI resources and assets
- `crcalc/` — constructive real arithmetic library used by the calculator
- `docs/` — design and implementation notes
- `Android.bp` — Soong build definition for the app

## Features

- Exact and high-precision numeric computation
- Android calculator UI with expandable result display
- Scientific notation and scrollable result precision
- Uses custom arithmetic logic instead of standard floating-point behavior

## Repository layout

```text
.
├── Android.bp
├── AndroidManifest.xml
├── CleanSpec.mk
├── MODULE_LICENSE_APACHE2
├── NOTICE
├── assets/
├── crcalc/
├── docs/
├── proguard.flags
├── res/
├── src/
└── README.md
