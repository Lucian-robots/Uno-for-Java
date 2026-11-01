# Uno Game

Welcome to the Uno Game, follow the quick steps below to set up and run the game on your mac.

## How to Install and Run

### Step 1: Open the Installer
1. Navigate to your `unoDistro` folder.
2. Double-click the **UnoGame.dmg** file to open it.

### Step 2: Move the Application
1. Drag the **UnoGame** application icon into your Mac's **Applications** folder (or into the `unoDistro` folder alongside your script).

### Step 3: Launch the Game
* Simply double-click the **run.command** file to launch the game instantly.

---

## Troubleshooting (First-Time Setup)

### "Permission Denied" Error
If macOS blocks the `.command` file from opening, your system needs permission to run it. 
1. Open your Mac's **Terminal** app.
2. Type the following command and hit **Enter**:
   ```bash
   chmod +x ~/Documents/unoDistro/run.command
   ```

### "Developer Cannot Be Verified" Error
Because the app is built locally, macOS Gatekeeper might show a security warning the first time you open it.
1. Go to your Mac's **System Settings** > **Privacy & Security**.
2. Scroll down to the **Security** section.
3. Click **Open Anyway** next to the warning about UnoGame.
