package io.lcalmsky.leetcode.robot_bounded_in_circle;

public class Solution {

  public boolean isRobotBounded(String instructions) {
    int x = 0;
    int y = 0;
    int index = 0;
    int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // (1) 각각 (x, y) 좌표를 나타내고 각 좌표는 북, 동, 남, 서를 나타냅니다.
    for (char instruction : instructions.toCharArray()) {
      if (instruction == 'R') { // (2) 명령이 R일 때 방향을 설정해줍니다. 처음 R일 때 1이므로 동, 그 다음은 2가 되어 남, 3이 되어 서, 0이 되어 북 순입니다.
        index = (index + 1) % 4;
        continue;
      }
      if (instruction == 'L') { // (3) 명령이 L일 때 방향을 설정해줍니다. 처음 L일 때 3이므로 서, 그 다음은 6이라 2가 되어 남, 다음은 5라 1이되고 동, 다음은 4라 0이되어 북 순입니다.
        index = (index + 3) % 4;
        continue;
      }
      x += directions[index][0]; // (4) 정해진 방향에 해당하는만큼 x 좌표를 이동시킵니다.
      y += directions[index][1]; // (5) 정해진 방향에 해당하는만큼 y 좌표를 이동시킵니다.
    }
    return (x == 0 && y == 0) || index != 0; // (6) 최종적으로 x, y좌표가 0이 되면 순환합니다. x, y좌표가 아닌 경우 위치가 이동했다는 것을 나타내고 이 때는 방향이 중요해집니다. index가 0이면 북쪽을 나타내는데 초기 방향이 북쪽이므로 위치는 이동한 상태에서 계속 같은 방향으로 이동하기 때문에 순환하지 않습니다. 반면 index가 1, 2, 3이 나온다면 각각 90도, 180도, 270도를 나타내고, 90도는 4번 반복, 180도는 2번 반복, 270도는 마찬가지로 4번 반복하면 초기 위치로 돌아올 수 있습니다.
  }
}
