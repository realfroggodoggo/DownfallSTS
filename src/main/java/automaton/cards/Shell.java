package automaton.cards;

import automaton.AutomatonMod;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;

import static automaton.AutomatonMod.makeBetaCardPath;

public class Shell extends AbstractBronzeCard {

    public final static String ID = makeID("Shell");

    //stupid intellij stuff skill, self, common

    private static final int BLOCK = 10;
    private static final int UPG_BLOCK = 5;

    public Shell() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        thisEncodes();
        baseMagicNumber = magicNumber = 1;
        AutomatonMod.loadJokeCardImage(this, makeBetaCardPath("Shell.png"));
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new BlurPower(p, magicNumber));
    }

   @Override
   public void onCompile(AbstractCard function, boolean forGameplay) {
       if (forGameplay && upgraded) {
                    applyToSelf(new BlurPower(AbstractDungeon.player, magicNumber));
               }
    }

    public void upp() {
       // upgradeBaseCost(1);
        rawDescription = UPGRADE_DESCRIPTION;
       initializeDescription();
    }
}