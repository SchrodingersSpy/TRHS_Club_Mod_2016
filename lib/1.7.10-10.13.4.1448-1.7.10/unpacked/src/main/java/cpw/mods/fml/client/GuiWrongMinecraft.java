/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     cpw - implementation
 */

package cpw.mods.fml.client;

import net.minecraft.client.gui.GuiErrorScreen;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;

public class GuiWrongMinecraft extends GuiErrorScreen
{
    private WrongMinecraftVersionException wrongMC;
    public GuiWrongMinecraft(WrongMinecraftVersionException wrongMC)
    {
        super(null,null);
        this.wrongMC = wrongMC;
    }
    @Override
    public void func_73866_w_()
    {
        super.func_73866_w_();
        this.field_146292_n.clear();
    }
    @Override
    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_146276_q_();
        int offset = 75;
        this.func_73732_a(this.field_146289_q, "Forge Mod Loader has found a problem with your minecraft installation", this.field_146294_l / 2, offset, 0xFFFFFF);
        offset+=10;
        this.func_73732_a(this.field_146289_q, String.format("The mod listed below does not want to run in Minecraft version %s", Loader.instance().getMinecraftModContainer().getVersion()), this.field_146294_l / 2, offset, 0xFFFFFF);
        offset+=5;
        offset+=10;
        this.func_73732_a(this.field_146289_q, String.format("%s (%s) wants Minecraft %s", wrongMC.mod.getName(), wrongMC.mod.getModId(), wrongMC.mod.acceptableMinecraftVersionRange()), this.field_146294_l / 2, offset, 0xEEEEEE);
        offset+=20;
        this.func_73732_a(this.field_146289_q, "The file 'ForgeModLoader-client-0.log' contains more information", this.field_146294_l / 2, offset, 0xFFFFFF);
    }
}
