FROM conda/miniconda3

WORKDIR /app

# Create the environment:
COPY environment.yaml .
RUN conda env create -f environment.yaml

# Make RUN commands use the new environment:
SHELL ["conda", "run", "-n", "dev", "/bin/bash", "-c"]

# Demonstrate the environment is activated:
RUN echo "Make sure flask is installed:"
RUN python -c "import flask"

# The code to run when container is started:
COPY hello.py .
ENTRYPOINT ["conda", "run",  "-n", "dev", "python", "hello.py"]