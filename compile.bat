@echo off
cd forge/mcp/
echo "Starting the Recompile MCP Script..."
call recompile.bat
echo:
echo:
echo:
echo "Recompile finished, Starting the Reobfuscate MCP Script..."
call reobfuscate.bat
echo:
echo:
echo:
echo "Copying assets from src/minecraft/assets"
robocopy src\minecraft\assets reobf\minecraft\assets /E 
echo:
echo "Copying the mcmod.info file from src/minecraft/mcmod.info"
robocopy mcmod\reobf\minecraft\ mcmod.info /E
echo:
echo:
cd reobf/minecraft
jar cf DCatcherMODJAM.jar net assets mcmod.info

echo "Build Complete. The file can be found in: reobf/minecraft/DCatcherMODJAM.jar :D"

pause