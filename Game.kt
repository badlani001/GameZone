import java.util.*

fun random(from: Int, to: Int) = (Math.random() * (to - from) + from).toInt()
fun guess() {
    var count: Int = 5
    val read = Scanner(System.`in`)
    val a: Int = random(1, 50)

    print("\n\t\t\tPLEASE GUESS A NUMBER: ")
    for (i in 1..5) {
        if( i in 2..5) {
            print("\n\t\t\tPLEASE GUESS ANOTHER NUMBER: ")
        }
        val ip = read.nextInt()
        if (ip > a) {
            print("\n\t\t\tHINT : YOU ARE GUESSING A HIGHER NUMBER")
            count-=1
            print("\n\t\t\tCHANCES LEFT : ${count}")
        } else if (ip < a) {
            count-=1
            print("\n\t\t\tHINT : YOU ARE GUESSING A LOWER NUMBER")
            print("\n\t\t\tCHANCES LEFT : ${count}")

        } else if (ip == a) {
            print("\n\t\t\t WOW YOU WON!!!")
            break
        }else{
            print("INVALID INPUT")
        }
    }
    print("\n\t\t\tCOMPUTER GUESS WAS: $a")
}


fun tic_tac_toe(){
    val read = Scanner(System.`in`)
    val random = Random()
    val board = Board()
    var inputCell = -1
    var computerCell = -1
    println(board.tutorialBoard)
    while(true) {
        print("\n\t\t\tWhich cell number do you want to mark? ")
        inputCell = read.nextInt() - 1
        while(board.cells[inputCell].state != CellState.EMPTY) {
            print("\n\t\t\tCell ${inputCell + 1} has already been chosen. Please pick a new cell ")
            inputCell = read.nextInt() - 1
        }
        board.cells[inputCell].state = CellState.CROSS
        if(board.isFull() || !(board.winState()==CellState.EMPTY)) break
        computerCell = inputCell
        while((board.cells[computerCell].state != CellState.EMPTY)) computerCell = random.nextInt(9)
        board.cells[computerCell].state = CellState.CIRCLE
        if(board.isFull() || !(board.winState()==CellState.EMPTY)) break
        println(board)
    }
    println(board)
    when(board.winState()) {
        CellState.EMPTY -> println("\n\t\t\tThis game was a draw")
        CellState.CIRCLE -> println("\n\t\t\tYou have lost the game")
        CellState.CROSS -> println("\n\t\t\tYou have won the game")
    }
}
private enum class CellState(val string: String, val value: Int) {
    EMPTY(" ", 0), CIRCLE("O", 1), CROSS("X", 2)
}
private data class Cell(var state: CellState = CellState.EMPTY){
    fun equals(other: Cell): Boolean = this.state == other.state
}
private class Board {
    val cells = arrayOf(Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell(), Cell())
    override fun toString(): String =
                    "\n\t\t\t"+
                    "-----------" + "\n" +
                    "\t\t\t" + cells[0].state.string + " | " + cells[1].state.string + " | " + cells[2].state.string + "\n" +
                    "\t\t\t-----------" + "\n" +
                    "\t\t\t" + cells[3].state.string + " | " + cells[4].state.string + " | " + cells[5].state.string + "\n" +
                    "\t\t\t-----------" + "\n" +
                    "\t\t\t" + cells[6].state.string + " | " + cells[7].state.string + " | " + cells[8].state.string + "\n"
    val tutorialBoard =
                    "\n\t\t\t"+
                    "-----------" + "\n" +
                    "\t\t\t" + "1" + " | " + "2" + " | " + "3" + "\n" +
                    "\t\t\t-----------" + "\n" +
                    "\t\t\t" + "4" + " | " + "5" + " | " + "6" + "\n" +
                    "\t\t\t-----------" + "\n" +
                    "\t\t\t" + "7" + " | " + "8" + " | " + "9" + "\n"
    fun winState(): CellState {
        if((cells[0].equals(cells[1]) && cells[0].equals(cells[2])) || (cells[0].equals(cells[3]) && cells[0].equals(cells[6])) || (cells[0].equals(cells[4]) && cells[0].equals(cells[8]))) return cells[0].state
        if(cells[1].equals(cells[4]) && cells[1].equals(cells[7])) return cells[1].state
        if((cells[2].equals(cells[4]) && cells[2].equals(cells[6])) || (cells[2].equals(cells[5]) && cells[2].equals(cells[8]))) return cells[2].state
        if(cells[6].equals(cells[7]) && cells[6].equals(cells[8])) return cells[6].state
        if(cells[3].equals(cells[4]) && cells[3].equals(cells[5])) return cells[3].state
        return CellState.EMPTY
    }
    fun isFull(): Boolean {
        for(cell in cells) if(cell.state.value==0) return false
        return true
    }

}

fun rps_again(score: Int) {

    print("\n\t\t\tWANT TO PLAY SAME GAME AGAIN? [Y/N]")
    val ch: String? = readLine()
    if (ch == "y" || ch == "Y"){
            rps(score)
        }
    else if (ch=="n" || ch=="N"){
            main()
        }
        else {
            print("\n\t\t\tINVALID CHOICE CHOOSE BETWEEN [Y/N]")
            rps_again(score)
        }
    }

fun rps(score: Int = 0){
    print("")
    val read = Scanner(System.`in`)
    var score:Int = score
    print("\n\t\t\tWELCOME TO ROCK, PAPER AND SCISSOR:")
    //print("\n\n\t\t\tGAME RULES:")
    //print("\n\t\t\tYOU ARE PLAYING WITH THE COMPUTER AND YOU HAVE TO CHHOSE BETWEEN THE THREE")
    print("\n\n\t\t\tIF YOU WIN YOU WILL BE AWARDED BY 1 POINT.")
    print("\n\t\t\tCONDITIONS TO WIN: ")
    print("\n\t\t\t\t\t\tROCK WINS OVER SCISSOR")
    print("\n\t\t\t\t\t\tPAPER WINS OVER ROCK")
    print("\n\t\t\t\t\t\tSCISSOR WINS OVER PAPER")
    var arr = arrayOf("rock","paper","scissor")
    var ran:String=arr.random()
    //print("\n\t\t\t$ran")

    print("\n\n\t\t\tChoose between ${java.util.Arrays.toString(arr)}")
    val ip:String = read.nextLine().trim()
   //print("\n\t\t\t ${ip} ${ran}")
    if (ip.equals(ran)){
              print("\n\t\t\tOhh, It's a tie")
              rps_again(0)
    }
    else if (ip == "rock" && ran == "scissor")
    {
                print("\n\t\t\tYOU WN!!")
                score+=1
                print("\n\t\t\tYOUR SCORE: ${score}")
                rps_again(score)
    }
    else if (ip=="rock" && ran=="paper") {
                print("\n\t\t\tCOMPUTER WINS!!")
                rps_again(0)
    }
    else if (ip=="paper" && ran=="rock") {
                print("\n\t\t\tYOU WON!!")
                score+=1
                print("\n\t\t\tYOUR SCORE: ${score}")
                rps_again(score)
    }
    else if (ip=="paper" && ran=="scissor") {
                print("\n\t\t\tCOMPUTER WINS!!")
                rps_again(0)
    }
    else if (ip=="scissor" && ran=="paper") {
                print("\n\t\t\tYOU WON!!")
                score+=1
                print("\n\t\t\tYOUR SCORE: ${score}")
                rps_again(score)
    }
    else if (ip=="scissor" && ran=="rock") {
                print("\n\t\t\tCOMPUTER WINS!!")
                rps_again(0)
    }
    else {
                print("\n\t\t\tInvalid input")
                rps()
    }
}

fun main() {
    val read = Scanner(System.`in`)
    print("\n\n\n")
    repeat(75) { print("*")}

    print("\n\n\t\t\tWelcome to Game World!!")
    print("\n\t\t\tShowing you Bunch of Games You can play here!!")
    print("\n\t\t\t1. GUESS THE NUMBER")
    print("\n\t\t\t2. TIC TAC TOE")
    print("\n\t\t\t3. ROCK PAPER SCISSOR")
    print("\n\n\t\t\tPlease make a choice...")
    val ch = read.nextInt()

    when (ch) {
            1 -> guess()
            2 -> tic_tac_toe()
            3-> rps()
            else -> print("\n\t\t\tInvalid Choice $ch")
        }
    }


