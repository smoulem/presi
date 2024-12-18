FROM ubuntu:focal AS build

# RUN groupadd --gid 1000 developer \
#   && useradd --uid 1000 --gid developer --shell /bin/bash --create-home developer

ENV DEBIAN_FRONTEND=1
ENV PATH /usr/lib/ccache:$PATH

# Install basic build tools
RUN apt-get update \
    && apt-get upgrade -y \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        make \
        unzip \
        # The tools in this package are used when installing packages for Python
        build-essential \
        swig3.0 \
        # Required for PostgreSQL
        libpq-dev \
        # Required for mysqlclient
        default-libmysqlclient-dev \
        # Required for ts
        moreutils \
        rsync \
        zip \
        libgdiplus \
        jq \
        # By default pip is not available in the buildpacks image
        # python-pip-whl \
        python3 \
        python-setuptools \
        python3-pip \
        #.NET Core related pre-requisites
        libc6 \
        libgcc1 \
        libgssapi-krb5-2 \
        libncurses5 \
        liblttng-ust0 \
        libssl-dev \
        libstdc++6 \
        zlib1g \
        libuuid1 \
        libunwind8 \
        sqlite3 \
        libsqlite3-dev \
        software-properties-common \
        tk-dev \
        uuid-dev \
        curl \
        nano \
        gettext \
        inotify-tools \
        sudo \
        git \
        wget \
        tree \
        fish \
        tmux \
    && rm -rf /var/lib/apt/lists/* \
    # This is the folder containing 'links' to benv and build script generator
    && apt-get update \
    && apt-get upgrade -y \
    && add-apt-repository universe \
    && rm -rf /var/lib/apt/lists/*

# USER developer

# COPY --chown=developer:developer ./scripts/ /home/developer/scripts/
# RUN /home/developer/scripts/aws/install --bin-dir /home/developer/.local/bin --install-dir /home/developer/.local/aws-cli --update
  
## sdkman
RUN curl -s "https://get.sdkman.io" | bash
# RUN sdk i java 17.0.12-amzn
# RUN sdk default java 17.0.12-amzn

# awsume
# RUN pipx install awsume
# RUN alias awsume=". awsume"

# WORKDIR /home/developer