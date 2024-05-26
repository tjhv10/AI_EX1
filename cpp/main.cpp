
#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <sstream>
#include "Container.cpp"
#include "Tools.cpp"
int main() {
    std::string filePath = "instances.txt";
    try {
        std::vector<std::string> initRows = extractInitRows(filePath);
        int i = 0;
        for (const auto& initRow : initRows) {
            std::cout << "Puzzle " << i << ":\n";
            i++;
            if (i == 15) {
                i++;
            }
            std::vector<std::vector<int>> superHardstate = convertStringTo2DArray(initRow);
            Container c(superHardstate);
            solvePuzzle(c);
        }
    } catch (const std::ios_base::failure& e) {
        std::cerr << e.what() << std::endl;
    } catch (const std::exception& e) {
        std::cerr << e.what() << std::endl;
    }
    return 0;
}