#ifndef CONTAINER_H
#define CONTAINER_H

#include <vector>

class Container {
public:
    Container(const std::vector<std::vector<int>>& state);
    // Other members of the Container class
private:
    std::vector<std::vector<int>> state;
};

#endif
