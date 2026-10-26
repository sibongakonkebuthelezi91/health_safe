CONTAINER_NAME := activemq


docker-active:
	if [-n $$(shell docker ps -aq -f name=$$(CONTAINER_NAME)) ]; then \
	echo "$(CONTAINER_NAME) Starting....."; \
	docker start $(CONTAINER_NAME); \
	else \
		echo "No container named $(CONTAINER_NAME)"; \
	fi

docker-stop:
	docker stop activemq

