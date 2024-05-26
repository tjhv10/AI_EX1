#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <string>
#include <sstream>
#include <fstream>
#include <chrono>
#include <algorithm>

using namespace std;

class Container {
public:
    vector<vector<int>> levels;
    int numOfColors;
    double heuristic;

    Container(vector<vector<int>> levels) : levels(levels), numOfColors(0), heuristic(0) {
        // Determine the number of colors
        unordered_set<int> colors;
        for (const auto& row : levels) {
            for (int color : row) {
                if (color != -1) {
                    colors.insert(color);
                }
            }
        }
        numOfColors = colors.size();
    }

    Container(const Container& other) : levels(other.levels), numOfColors(other.numOfColors), heuristic(other.heuristic) {}

    void setLevels(const vector<vector<int>>& newLevels) {
        levels = newLevels;
    }

    int getNumOfColors() const {
        return numOfColors;
    }

    double getHeuristic() const {
        return calculateHeuristic(*this);
    }

    void setHeuristic(double h) {
        heuristic = calculateHeuristic(*this);
    }

    bool operator==(const Container& other) const {
        return levels == other.levels;
    }

    bool operator!=(const Container& other) const {
        return !(*this == other);
    }

    string toString() const {
        ostringstream oss;
        for (const auto& row : levels) {
            for (int val : row) {
                oss << val << " ";
            }
            oss << "\n";
        }
        return oss.str();
    }
};

// Custom hash function for Container
struct ContainerHasher {
    size_t operator()(const Container& c) const {
        string s = c.toString();
        return hash<string>()(s);
    }
};

int top(const vector<int>& arr) {
    bool flag = false;
    if (arr[0] == -1) flag = true;
    for (size_t i = 0; i < arr.size() - 1; ++i) {
        if (arr[i + 1] != -1) {
            if (flag) return i + 1;
            return i;
        }
    }
    return -1;
}

bool full(const vector<int>& arr) {
    return arr[0] != -1;
}

bool isValidMove(int i1, int i2, const vector<vector<int>>& c1) {
    if (top(c1[i1]) == -1) return false;
    return top(c1[i2]) == -1 || (c1[i1][top(c1[i1])] == c1[i2][top(c1[i2])] && !full(c1[i2]));
}

void performMove(int fromContainer, int toContainer, Container& container) {
    auto& levels = container.levels;
    int color = levels[fromContainer][top(levels[fromContainer])];
    while (top(levels[fromContainer]) != -1 && levels[fromContainer][top(levels[fromContainer])] == color && !full(levels[toContainer])) {
        levels[fromContainer][top(levels[fromContainer])] = -1;
        if (top(levels[toContainer]) == -1) {
            levels[toContainer][levels[toContainer].size() - 1] = color;
        } else {
            levels[toContainer][top(levels[toContainer]) - 1] = color;
        }
    }
    container.setLevels(levels);
}

bool isGoalState(const Container& c) {
    int cur;
    for (const auto& level : c.levels) {
        cur = level[0];
        for (int val : level) {
            if (cur != val) return false;
        }
    }
    return true;
}

int calculateHeuristic(const Container& c) {
    int heuristicValue = 0;
    vector<int> res(c.getNumOfColors(), 0);
    int color;

    for (const auto& level : c.levels) {
        if (top(level) != -1) {
            for (int j = level.size() - 1; j > top(level); --j) {
                color = level[j];
                while (j > top(level) && level[j - 1] == color) {
                    --j;
                }
                res[color] += j - top(level);
            }
        }
    }

    for (int val : res) {
        heuristicValue += val;
    }
    for (size_t i = 1; i < c.levels.size(); ++i) {
        if (top(c.levels[i]) != -1) {
            ++heuristicValue;
        }
    }
    heuristicValue -= res.size() - 2;
    return heuristicValue;
}

void print2DArray(const vector<vector<int>>& array) {
    for (const auto& row : array) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }
}

void printArray(const vector<int>& array) {
    for (int val : array) {
        cout << val << " ";
    }
    cout << endl;
}

vector<Container> generateNeighbors(const Container& currentContainer) {
    vector<Container> neighbors;
    int numContainers = currentContainer.levels.size();

    for (int from = 0; from < numContainers; ++from) {
        for (int to = 0; to < numContainers; ++to) {
            if (isValidMove(from, to, currentContainer.levels) && from != to) {
                Container neighbor(currentContainer);
                performMove(from, to, neighbor);
                neighbor.setHeuristic(calculateHeuristic(neighbor));
                neighbors.push_back(neighbor);
            }
        }
    }

    return neighbors;
}

bool arraysEqual(const vector<int>& arr1, const vector<int>& arr2) {
    return arr1 == arr2;
}

vector<int> findDifferentLevelIndex(const vector<vector<int>>& levels1, const vector<vector<int>>& levels2) {
    vector<int> diffIndex(2, -1);
    bool flag = false;

    for (size_t i = 0; i < levels1.size(); ++i) {
        if (!arraysEqual(levels1[i], levels2[i])) {
            if (!flag) {
                diffIndex[0] = i + 1;
                flag = true;
            } else {
                diffIndex[1] = i + 1;
                break;
            }
        }
    }

    return diffIndex;
}

pair<int, long> outputSolutionPath(const Container& goalContainer, const unordered_map<Container, Container, ContainerHasher>& parentMap, long elapsedTime) {
    pair<int, long> result;
    vector<string> path;
    Container current = goalContainer;

    while (parentMap.find(current) != parentMap.end()) {
        Container parent = parentMap.at(current);
        auto diffIndex = findDifferentLevelIndex(parent.levels, current.levels);
        string action = "Swap container " + to_string(diffIndex[0]) + " with " + to_string(diffIndex[1]);
        path.push_back(action + "\n" + current.toString());
        current = parent;
    }

    reverse(path.begin(), path.end());

    cout << "Puzzle has been solved in " << path.size() << " steps in " << elapsedTime << " milliseconds!" << endl;
    result.first = path.size();
    result.second = elapsedTime;
    return result;
}

void updateOpenSet(unordered_map<int, Container>& openSet, unordered_set<string>& closedSet, const vector<Container>& neighbors) {
    for (const auto& neighborContainer : neighbors) {
        int neighborHashCode = hash<string>()(neighborContainer.toString());
        if (closedSet.find(neighborContainer.toString()) == closedSet.end() && openSet.find(neighborHashCode) == openSet.end()) {
            openSet[neighborHashCode] = neighborContainer;
        }
    }
}

Container getMinCostContainer(unordered_map<int, Container>& openSet) {
    Container minContainer({{}});
    double minHeuristic = numeric_limits<double>::max();

    for (const auto& entry : openSet) {
        double heuristic = entry.second.getHeuristic();
        if (heuristic < minHeuristic) {
            minHeuristic = heuristic;
            minContainer = entry.second;
        }
    }

    return minContainer;
}

vector<vector<int>> convertStringTo2DArray(const string& input) {
    istringstream iss(input);
    string line;
    vector<vector<int>> result;

    while (getline(iss, line)) {
        vector<int> row;
        istringstream rowStream(line);
        int val;
        while (rowStream >> val) {
            row.push_back(val);
        }
        result.push_back(row);
    }

    return result;
}

vector<int> fillArrayFromTop(const vector<int>& arr, int maxLength) {
    vector<int> result(maxLength, -1);
    int len = arr.size();
    int diff = maxLength - len;

    for (int i = len - 1; i >= 0; --i) {
        result[i + diff] = arr[i];
    }

    return result;
}

pair<int, long> solvePuzzle(Container initialContainer) {
    unordered_map<int, Container> openSet;
    unordered_set<string> closedSet;
    unordered_map<Container, Container, ContainerHasher> parentMap;
    openSet[hash<string>()(initialContainer.toString())] = initialContainer;

    auto startTime = chrono::high_resolution_clock::now();

    while (!openSet.empty()) {
        Container currentContainer = getMinCostContainer(openSet);

        if (isGoalState(currentContainer)) {
            auto endTime = chrono::high_resolution_clock::now();
            auto elapsedTime = chrono::duration_cast<chrono::milliseconds>(endTime - startTime).count();
            return outputSolutionPath(currentContainer, parentMap, elapsedTime);
        }

        string stateHash = currentContainer.toString();
        closedSet.insert(stateHash);
        openSet.erase(hash<string>()(stateHash));

        auto neighbors = generateNeighbors(currentContainer);
        updateOpenSet(openSet, closedSet, neighbors);

        for (const auto& neighbor : neighbors) {
            parentMap[neighbor] = currentContainer;
        }
    }

    auto endTime = chrono::high_resolution_clock::now();
    auto elapsedTime = chrono::duration_cast<chrono::milliseconds>(endTime - startTime).count();
    cout << "No solution found. Time elapsed: " << elapsedTime << " milliseconds." << endl;

    return {-1, elapsedTime};
}
bool starts_with(const std::string& str, const std::string& prefix) {
    return str.substr(0, prefix.size()) == prefix;
}
vector<string> extractInitRows(const string& filePath) {
    vector<string> initRows;
    ifstream file(filePath);
    string line;
    stringstream section;

    while (getline(file, line)) {
        if (starts_with(line,"####")) {
            if (section.str().length() > 0) {
                initRows.push_back(extractInitRow(section.str()));
                section.str("");
                section.clear();
            }
        } else {
            section << line << "\n";
        }
    }

    if (section.str().length() > 0) {
        initRows.push_back(extractInitRow(section.str()));
    }

    return initRows;
}

string extractInitRow(const string& section) {
    istringstream iss(section);
    string line;

    while (getline(iss, line)) {
        if (line.find("init=") != string::npos) {
            return line.substr(line.find("=") + 1);
        }
    }

    return "";
}