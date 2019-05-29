
package minecraft;

import java.util.ArrayList;

public class Grass extends Block 
{
    @Override
    public ArrayList<Block> dropItems(Tool.ToolType type) 
    {
        ArrayList<Block> blocks = new ArrayList<>();
        switch(type)
        {
            case Hammer:
                blocks.add(new Grass());
                blocks.add(new Land());
                break;
            case Sword:
                blocks.add(new Land());
                break;
            case Shovel:
                blocks.add(new Land());
                blocks.add(new Land());
                blocks.add(new Land());
                break;
            default:
                break;
        }
        return blocks;
    }

    @Override
    public String getName() {
        return "Grass";
    }
    
    
}
