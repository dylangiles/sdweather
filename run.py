import RPi.GPIO
import time
from subprocess import call, check_output

GPIO.setmode(GPIO.BCM)
GPIO.setup(21, GPIO.IN, pull_up_down=GPIO.PUD_UP)

while True:
    input_state = GPIO.input(21)
    if input_state == True:
        result = check_output(['cat', '/dev/ttyACM0'])
        call(["java", "-jar", "sdweather.jar", result])
        time.sleep(1.5)