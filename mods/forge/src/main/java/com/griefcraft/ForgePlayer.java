package com.griefcraft;/*
 * Copyright (c) 2011, 2012, Tyler Blair
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

import com.griefcraft.entity.Player;
import com.griefcraft.util.Color;
import com.griefcraft.world.ForgeWorld;
import net.minecraft.entity.player.EntityPlayerMP;

public class ForgePlayer extends Player {

    /**
     * The mod handle
     */
    private LWC mod;

    /**
     * Player handle
     */
    private EntityPlayerMP handle;

    public ForgePlayer(EntityPlayerMP handle) {
        this.handle = handle;
        this.mod = LWC.instance;
    }

    @Override
    public String getName() {
        return handle.getEntityName();
    }

    public Location getLocation() {
        try {
            return new Location(new ForgeWorld(handle.worldObj), (int) handle.posX, (int) handle.posY, (int) handle.posZ);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void sendMessage(String message) {
        for (String line : message.split("\n")) {
            handle.sendChatToPlayer(Color.replaceColors(line));
        }
    }

    public boolean hasPermission(String node) {
        return true; // TODO check for OP from lwc.admin.*, allow any others
    }

}