CONTAINER_NAME := activemq


docker-active:
	@if [-n $$(shell docker ps -aq -f name=$$(CONTAINER_NAME)) ]; then \
	echo "$(CONTAINER_NAME) Starting....."; \
	docker start $(CONTAINER_NAME); \
	else \
		echo "No container named $(CONTAINER_NAME)"; \
		docker run -d --name activemq -p 61616:61616 -p 8161:8161 apache/activemq-classic:latest; \
	fi

docker-stop:
	docker stop activemq

docker-check-instance:
	docker ps -aq