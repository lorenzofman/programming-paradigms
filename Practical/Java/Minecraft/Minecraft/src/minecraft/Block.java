/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minecraft;

import java.util.ArrayList;

/**
 *
 * @author hp37
 */
public abstract class Block 
{
    public abstract String getName();
    public abstract ArrayList<Block> dropItems(Tool.ToolType type);
}
