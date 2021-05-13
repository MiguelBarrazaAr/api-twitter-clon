import unittest
import requests
import json

class TestApi(unittest.TestCase):
	host = "http://localhost:7000"

	def test_RegistramosUnNuevoUsuario(self):
		info = {"name": "Edward Elric",
    "email": "edwardElric@gmail.com",
    "password": "philosopherStone",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"}
		r = requests.post(self.host+"/register", json.dumps(info))
		data=r.json()
		self.assertEqual(r.status_code, 201)
		self.assertEqual(data.get('result',None),'ok')
