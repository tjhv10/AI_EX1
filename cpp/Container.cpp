#include <vector>
#include <unordered_set>
#include <string>
#include <sstream>
#include <algorithm>
#include <iostream>

using namespace std;


class Container {
private:
    vector<vector<int>> levels;
    int heuristic;
    int numOfColors;

public:
    int numOfColores() {
        unordered_set<int> set;
        for (const auto& row : levels) {
            for (const auto& num : row) {
                set.insert(num);
            }
        }
        return set.size();
    }

    int getNumOfColores() const {
        return numOfColors;
    }

    Container(const vector<vector<int>>& levels) : levels(levels) {
        this->numOfColors = numOfColores();
        this->heuristic = getHeuristic();
    }

    Container() : heuristic(0), numOfColors(0) {}

    Container(const Container& other) {
        this->levels = other.levels;
        this->heuristic = other.heuristic;
        this->numOfColors = other.numOfColors;
    }

    vector<vector<int>> getLevels() const {
        return levels;
    }

    void setLevels(const vector<vector<int>>& levels) {
        this->levels = levels;
    }

    int getHeuristic() const;

    void setHeuristic(int val) {
        this->heuristic = val;
    }

    string toString() const {
        stringstream ss;
        for (const auto& row : levels) {
            ss << "[";
            for (size_t i = 0; i < row.size(); ++i) {
                ss << row[i];
                if (i < row.size() - 1) ss << ", ";
            }
            ss << "]\n";
        }
        ss << "Heuristic value: " << heuristic;
        return ss.str();
    }

    // Overload the less than operator for using Container in sets and maps
    bool operator<(const Container& other) const {
        return this->heuristic < other.heuristic;
    }

    // Overload the equality operator for using Container in sets and maps
    bool operator==(const Container& other) const {
        return this->levels == other.levels;
    }

    // Hash function for Container for use in unordered maps and sets
    struct HashFunction {
        size_t operator()(const Container& container) const {
            size_t hash = 0;
            for (const auto& row : container.levels) {
                for (const auto& num : row) {
                    hash ^= hash * 31 + hash + num;
                }
            }
            return hash;
        }
    };
};

// Forward declaration of Tools class methods to resolve dependency issues
int Tools_calculateHeuristic(const Container& c);

int Container::getHeuristic() const {
    return Tools_calculateHeuristic(*this);
}

// Sample implementation of the Tools_calculateHeuristic function
int Tools_calculateHeuristic(const Container& c) {
    // Placeholder implementation, replace with the actual heuristic calculation logic
    return 0;
}

int main() {
    vector<vector<int>> levels = {{1, 2}, {3, 4}, {5, 6}};
    Container container(levels);

    cout << container.toString() << endl;

    return 0;
}
