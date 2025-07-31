

// Interface for all characters
interface Character {
    String getDescription();
    int getPower();
}

// Concrete character classes
class Warrior implements Character {
    @Override
    public String getDescription() {
        return "Warrior";
    }

    @Override
    public int getPower() {
        return 100;
    }
}

class Archer implements Character {
    @Override
    public String getDescription() {
        return "Archer";
    }

    @Override
    public int getPower() {
        return 80;
    }
}

class Mage implements Character {
    @Override
    public String getDescription() {
        return "Mage";
    }

    @Override
    public int getPower() {
        return 70;
    }
}

// Abstract decorator class
abstract class CharacterDecorator implements Character {
    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract int getPower();
}

// Concrete decorators (upgrades)
class FireEnchantment extends CharacterDecorator {
    public FireEnchantment(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with Fire Enchantment";
    }

    @Override
    public int getPower() {
        return character.getPower() + 30;
    }
}

class ArmorUpgrade extends CharacterDecorator {
    public ArmorUpgrade(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with Armor Upgrade";
    }

    @Override
    public int getPower() {
        return character.getPower() + 40;
    }
}

class SpeedBoost extends CharacterDecorator {
    public SpeedBoost(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with Speed Boost";
    }

    @Override
    public int getPower() {
        return character.getPower() + 20;
    }
}

class MagicShield extends CharacterDecorator {
    public MagicShield(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " with Magic Shield";
    }

    @Override
    public int getPower() {
        return character.getPower() + 50;
    }
}

// Main application class
public class Test {

    public static void main(String[] args) {
        // Warrior with multiple upgrades
        Character warrior = new Warrior();
        warrior = new FireEnchantment(warrior);
        warrior = new ArmorUpgrade(warrior);
        warrior = new SpeedBoost(warrior);

        System.out.println("Character: " + warrior.getDescription());
        System.out.println("Total Power: " + warrior.getPower());

        // Mage with magic shield and fire enchantment
        Character mage = new Mage();
        mage = new MagicShield(mage);
        mage = new FireEnchantment(mage);

        System.out.println("\nCharacter: " + mage.getDescription());
        System.out.println("Total Power: " + mage.getPower());
    }
}
