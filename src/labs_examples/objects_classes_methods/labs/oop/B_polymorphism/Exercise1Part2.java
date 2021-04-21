package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Exercise1Part2 {

    public static void main(String[] args) {

        // Creating two new objects, a guitar and a piano, both of which are subclasses of instruments, so they have the
        // notes and octaves contained within the instruments class with the attributes below

        Guitars myGuitar = new Guitars("Jackson", true, 24);
        // I needed to tune my guitar.
        myGuitar.tuneInstrument();

        Pianos yourPiano = new Pianos("Korg", true, 112);


        // The playMelody method is overloaded to intake 3 to 5 notes

        myGuitar.playMelody(120,4,0,3,7);
        myGuitar.playMelody(100, 6,3,5,7,8);
        myGuitar.playMelody(150,7,3,0,2,5,8);

        // The methods from the PlayInstrument interface are overridden to fit each instrument's range and behavior

        myGuitar.playCMajorChord();
        yourPiano.playCMajorChord();
        yourPiano.playCMajorScale();
        myGuitar.playLostWoodsIntro();
        yourPiano.playEveryKey();

        // I can use the interface as an instance variable as demonstrated below in the class CurrentInstrument, which
        // holds the object as an instance variable that I can change and play the tunes on.

        CurrentInstrument currentInstrument = new CurrentInstrument(yourPiano);
        System.out.println("I am currently playing the piano.");
        currentInstrument.playCurrentInstrument();
        currentInstrument.setCurrentInstrument(myGuitar);
        System.out.println("Now, I have switched to the guitar.");
        currentInstrument.playCurrentInstrument();

        }

}

class CurrentInstrument{
    private PlayInstrument currentInstrument;

    public void playCurrentInstrument(){
        currentInstrument.playCMajorChord();
        currentInstrument.playCMajorScale();
        currentInstrument.playLostWoodsIntro();
    }

    public CurrentInstrument(PlayInstrument currentInstrument) {
        this.currentInstrument = currentInstrument;
    }

    public PlayInstrument getCurrentInstrument() {
        return currentInstrument;
    }

    public void setCurrentInstrument(PlayInstrument currentInstrument) {
        this.currentInstrument = currentInstrument;
    }
}

interface PlayInstrument{

    public void playCMajorScale();
    public void playCMajorChord();
    public void playLostWoodsIntro();

}

class Instruments{

    private static String[] notes = {"A", "A#", "B", "C", "C#", "D", "D#","E", "F", "F#", "G", "G#"};
    private static int[] octaves = {0,1,2,3,4,5,6,7,8};

    void tuneInstrument(){
        System.out.println("You tune your instrument back into the correct pitch.");
    }

    public void playMelody(int bpm, int octave, int note1, int note2, int note3){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " at " + bpm + " beats per minute in the " + octaves[octave] + "th octave.");
    }
    public void playMelody(int bpm, int octave, int note1, int note2, int note3, int note4){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " " + notes[note4] + " at " + bpm +
                " beats per minute in the " + octaves[octave] + "th octave.");
    }

    public void playMelody(int bpm, int octave, int note1, int note2, int note3, int note4, int note5){
        System.out.println("You play " + notes[note1] + " " + notes[note2]
                + " " + notes[note3] + " " + notes[note4] + " " + notes[note5] + " at " + bpm +
                " beats per minute in the " + octaves[octave] + "th octave.");
    }

    public static String playNoteAtOctave(int note, int octave){
        return notes[note] + octaves[octave];
    }

    public static String[] getNotes() {
        return notes;
    }


    public static int[] getOctaves() {
        return octaves;
    }

}

class Guitars extends Instruments implements PlayInstrument{

    String manufacturer;
    boolean isElectric;
    int numFrets;

    @Override
    public void playCMajorScale() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You pluck out the C major scale: \n"
                + playNoteAtOctave(3,5) + " " + playNoteAtOctave(5,5) + " "
                + playNoteAtOctave(7,5) + " " + playNoteAtOctave(8,5) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(3,6) + ".");
    }

    @Override
    public void playCMajorChord() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You strum the C major chord: \n"
                + playNoteAtOctave(3,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(10,5));
    }

    @Override
    public void playLostWoodsIntro() {
        System.out.println("You pick up your " + this.manufacturer + " guitar, with " + numFrets + " frets and...");
        if(isElectric == true){
            System.out.println("You proceed to plug it into the amplifier.");
        }
        System.out.println("You begin to pick the Lost Woods Theme: \n"
                + playNoteAtOctave(8,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(8,5) + " "
                + playNoteAtOctave(0,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(8,5) + " " + playNoteAtOctave(0,6) + " "
                + playNoteAtOctave(2,6) + " " + playNoteAtOctave(7,6) + " "
                + playNoteAtOctave(5,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(3,6) + " " + playNoteAtOctave(2,6) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(5,5) + " " + playNoteAtOctave(7,5) + " "
                + playNoteAtOctave(10,5) + " " + playNoteAtOctave(7,5) + ".");
    }

    public Guitars(String manufacturer, boolean isElectric, int numFrets) {
        this.manufacturer = manufacturer;
        this.isElectric = isElectric;
        this.numFrets = numFrets;
    }
}

class Pianos extends Instruments implements PlayInstrument{

    String manufacturer;
    boolean isSynth;
    int numKeys;

    public void playEveryKey(){
        int counter = 0;
        for(int j = 0; j < getOctaves().length; j++){
            for(int i = 0; i < getNotes().length; i++){
                System.out.print(playNoteAtOctave(i,j));
                System.out.print("|");
                counter++;
                if(counter % 20 == 0){
                    System.out.println();
                }
                if(counter == numKeys){
                    return;
                }
            }
        }
    }

    @Override
    public void playCMajorScale() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
        }
        System.out.println("Then, you gently play the C major scale: \n"
                + playNoteAtOctave(3,4) + " " + playNoteAtOctave(5,4) + " "
                + playNoteAtOctave(7,4) + " " + playNoteAtOctave(8,4) + " "
                + playNoteAtOctave(10,4) + " " + playNoteAtOctave(0,5) + " "
                + playNoteAtOctave(2,5) + " " + playNoteAtOctave(3,5) + ".");
    }

    @Override
    public void playCMajorChord() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
            System.out.println("You strike the keys and play the C major chord: \n"
                    + playNoteAtOctave(3,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(10,4));
        }

    }

    @Override
    public void playLostWoodsIntro() {
        System.out.println("You sit down at your " + this.manufacturer + " piano, with " + numKeys + " keys and...");
        if(isSynth == true){
            System.out.println("Because it is a synth, you first choose your favorite setting.");
            System.out.println("You begin to plunk along to the Lost Woods Theme on your keyboard: \n"
                    + playNoteAtOctave(8,4) + " " + playNoteAtOctave(0,5) + " "
                    + playNoteAtOctave(2,5) + " " + playNoteAtOctave(8,4) + " "
                    + playNoteAtOctave(0,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(8,4) + " " + playNoteAtOctave(0,5) + " "
                    + playNoteAtOctave(2,5) + " " + playNoteAtOctave(7,5) + " "
                    + playNoteAtOctave(5,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(3,5) + " " + playNoteAtOctave(2,5) + " "
                    + playNoteAtOctave(10,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(5,4) + " " + playNoteAtOctave(7,4) + " "
                    + playNoteAtOctave(10,4) + " " + playNoteAtOctave(7,4) + ".");
        }

    }

    public Pianos(String manufacturer, boolean isSynth, int numKeys) {
        this.manufacturer = manufacturer;
        this.isSynth = isSynth;
        this.numKeys = numKeys;
    }
}