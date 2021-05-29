import pygame
import random

"""
1. Classes are great way to describe game objects.
   Let's create a class for the ball. Ball should store
   position (tuple of 2 ints, or 2 ints), radius and speed.
   As we have 2D plane speed should be described by two value
   speedX and speedY.
   Ball should have constructor that gets position and radius.
   speed should be 0 at first. We also need Update and Render
   methods. Update method should change position based on the
   speed. Render method should take screen as an argument
   and draw circle on it.
"""


# pygame.draw.circle(screen, color, (x,y), radius)
class Ball:
    def __init__(self, positionX, positionY, radius):
        self.positionX = positionX
        self.positionY = positionY
        self.radius = radius
        self.speedX = 0
        self.speedY = 0

    def update(self):
        self.positionX += self.speedX
        self.positionY += self.speedY
        if not 10 <= self.positionX <= 890:
            self.speedX = -self.speedX
        if not 10 <= self.positionY <= 490:
            self.speedY = -self.speedY

    def render(self, screen):
        pygame.draw.circle(screen, pygame.Color("White"),
                           (self.positionX, self.positionY), self.radius)


"""
2. We need separate main class for the game. It should follow
   simple game loop structure with run, init, update, event, render, cleanup
   methods. Additionally we need to have ball attribute, which should
   be initialised in init method.
3. To make ball move, we add random speed in the beginning to it.
"""


class Game:
    def __init__(self):
        self.ball = None
        self.screen = None
        self.clock = None
        self.running = False

    def init(self):
        self.ball = Ball(100, 100, 10)
        self.ball.speedX = random.randint(-5, 5)
        self.ball.speedY = random.randint(-5, 5)
        self.screen = pygame.display.set_mode((900, 500))
        self.clock = pygame.time.Clock()
        self.running = True

    def event(self):
        for ev in pygame.event.get():
            if ev.type == pygame.QUIT:
                self.running = False

    def update(self):
        self.event()
        self.ball.update()

    def render(self):
        pygame.display.flip()
        self.clock.tick(60)
        self.screen.fill((0, 0, 0))
        self.ball.render(self.screen)

    def run(self):
        self.init()
        while self.running:
            self.render()
            self.update()
        pygame.quit()


if __name__ == '__main__':
    game = Game()
    game.run()
